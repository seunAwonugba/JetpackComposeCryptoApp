package com.example.base.usecase

import com.example.base.repository.SingleCoinRepository
import com.example.base.utils.Resource
import com.example.base.view.SingleCoinResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSingleCoinUseCase @Inject constructor(
    private val singleCoinRepository: SingleCoinRepository
) {
    //operation function calls a class like a function
    //add kotlin coroutine flow dependency
    operator fun invoke(coinId : String) : Flow<Resource<SingleCoinResponse>> = flow {
        try {
            emit(Resource.Loading())

            val response = singleCoinRepository.getSingleCoin(coin_id = coinId)
            val data = response.body()

            if (response.isSuccessful){
                if (data != null){
                    emit(Resource.Success(
                        data = SingleCoinResponse(
                            description = data.description ?: "Description not available",
                            development_status = data.development_status?: "",
                            first_data_at = data.first_data_at?: "",
                            id = data.id?: "",
                            is_active = data.is_active?: false,
                            is_new = data.is_new?: false,
                            last_data_at = data.last_data_at?: "",
                            links = data.links,
                            links_extended = data.links_extended,
                            name = data.name?: "",
                            rank = data.rank?: 0,
                            started_at = data.started_at?: "",
                            symbol = data.symbol?: "",
                            tags = data.tags,
                            team = data.team,
                            type = data.type?: "",
                            whitepaper = data.whitepaper
                        )
                    ))
                }
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