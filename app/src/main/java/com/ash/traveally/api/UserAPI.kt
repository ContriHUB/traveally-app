package com.ash.traveally.api

import com.ash.traveally.models.LoginRequest
import com.ash.traveally.models.LoginResponse
import com.ash.traveally.models.Message
import com.ash.traveally.models.RegisterResponse
import com.ash.traveally.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("/api/auth/register")
    suspend fun register(@Body registerRequest: User) : Response<RegisterResponse>

    @POST("/api/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest) : Response<LoginResponse>
}