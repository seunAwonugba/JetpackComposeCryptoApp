package com.example.base.usecase

import com.example.base.repository.AllCoinsRepository
import com.example.base.utils.Resource
import com.example.base.view.AllCoinsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(
    private val allCoinsRepository: AllCoinsRepository
) {
    //because i'm fetching all items which is a list, hence i'm returning flow,resource,list of all the data
    operator fun invoke() : Flow<Resource<List<AllCoinsResponse>>> = flow{
        try {
            emit(Resource.Loading())

            val response = allCoinsRepository.getAllCoins()
            val data = response.body()

            if (response.isSuccessful && data != null){
                emit(Resource.Success(
                    data = data.map {
                        AllCoinsResponse(
                            id = it.id,
                            is_active = it.is_active,
                            name = it.name,
                            rank = it.rank,
                            symbol = it.symbol,
                            type = it.type
                        )
                    }
                ))
            }else{
                emit(Resource.Error("A ${response.code()} error occurred: caused by : ${response.message()}"))
            }
        }catch (err : HttpException){
            emit(Resource.Error("A ${err.code()} error occurred: caused by : ${err.message()}"))
        }catch (err : IOException){
            emit(Resource.Error("An error occurred: caused by ${err.message}"))
        }
    }
}