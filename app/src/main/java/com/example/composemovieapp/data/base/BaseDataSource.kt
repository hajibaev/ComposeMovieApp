package com.example.composemovieapp.data.base

import com.example.composemovieapp.domain.base.AnotherError
import com.example.composemovieapp.domain.base.ResultModel
import retrofit2.HttpException
import retrofit2.Response


abstract class BaseDataSource {

    protected suspend fun <T> invokeRequest(request: suspend () -> Response<T>): ResultModel<T> {
        return try {
            val response = request()
            if (response.isSuccessful) ResultModel.success(response.body())
            else ResultModel.error(
                AnotherError(
                    response.message(),
                    response.code(),
                )
            )
        } catch (httpException: HttpException) {
            ResultModel.error(httpException)
        } catch (exception: Exception) {
            ResultModel.error(exception)
        }
    }
}