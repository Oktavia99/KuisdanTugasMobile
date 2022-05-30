package comf55118081.example.tugasmobile

import comf55118081.example.tugasmobile.data.model.DetailUser
import comf55118081.example.tugasmobile.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users" )
    @Headers( "Authorization: token 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" )

    fun getSearchUsers (
        @Query ( "q" ) query : String
    ): Call<UserResponse>

    @GET( "users/{username}" )
    @Headers( "Authorization: token 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" )

    fun getUserDetail (
        @Path ( "username" ) username : String
    ): Call<DetailUser>
}