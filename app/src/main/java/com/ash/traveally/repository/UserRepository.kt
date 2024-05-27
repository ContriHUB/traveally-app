package com.ash.traveally.repository

import com.ash.traveally.api.UserAPI
import com.ash.traveally.models.LoginRequest
import com.ash.traveally.models.LoginResponse
import com.ash.traveally.models.Message
import com.ash.traveally.models.RegisterResponse
import com.ash.traveally.models.User
import com.ash.traveally.utils.NetworkResult
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userAPI: UserAPI
) {

    suspend fun registerUser(registerRequest: User): NetworkResult<RegisterResponse> {
        try {
            val response = userAPI.register(registerRequest)
            if (response.isSuccessful && response.body() != null) {
                return NetworkResult.Success(response.body()!!)
            }
        } catch (e : Exception) {
            return NetworkResult.Error(e.message)
        }
        return NetworkResult.Error("Something went wrong")
    }

    suspend fun loginUser(loginRequest: LoginRequest): NetworkResult<LoginResponse> {
        try {
            val response = userAPI.login(loginRequest)
            if (response.isSuccessful && response.body() != null) {
                return NetworkResult.Success(response.body()!!);
            }
        } catch (e : Exception) {
            return NetworkResult.Error(e.message);
        }
        return NetworkResult.Error("Something went wrong")
    }
}
