package com.upar24.chattingtrading.data.remote

import com.upar24.chattingtrading.data.local.entities.*
import com.upar24.chattingtrading.data.remote.requests.AccountRequest
import com.upar24.chattingtrading.data.remote.requests.ListStringRequest
import com.upar24.chattingtrading.data.remote.requests.OneRequest
import com.upar24.chattingtrading.data.remote.requests.UpdateUserRequest
import com.upar24.chattingtrading.data.remote.responses.SimpleResponse
import com.upar24.chattingtrading.util.KangDooShik.deleteDropPath
import com.upar24.chattingtrading.util.KangDooShik.deleteTradingPath
import com.upar24.chattingtrading.util.KangDooShik.deleteWallPath
import com.upar24.chattingtrading.util.KangDooShik.getAllTradingPath
import com.upar24.chattingtrading.util.KangDooShik.getAllUserTradingPath
import com.upar24.chattingtrading.util.KangDooShik.getBuyingSearchPath
import com.upar24.chattingtrading.util.KangDooShik.getChatPath
import com.upar24.chattingtrading.util.KangDooShik.getDescriptionSearchPath
import com.upar24.chattingtrading.util.KangDooShik.getListUserClubPath
import com.upar24.chattingtrading.util.KangDooShik.getListUserIgnPath
import com.upar24.chattingtrading.util.KangDooShik.getListUserPath
import com.upar24.chattingtrading.util.KangDooShik.getPartyPath
import com.upar24.chattingtrading.util.KangDooShik.getSellingSearchPath
import com.upar24.chattingtrading.util.KangDooShik.getTitleSearchPath
import com.upar24.chattingtrading.util.KangDooShik.getTradingPath
import com.upar24.chattingtrading.util.KangDooShik.getUserPath
import com.upar24.chattingtrading.util.KangDooShik.getWallPath
import com.upar24.chattingtrading.util.KangDooShik.loginPath
import com.upar24.chattingtrading.util.KangDooShik.registerPath
import com.upar24.chattingtrading.util.KangDooShik.saveChatPath
import com.upar24.chattingtrading.util.KangDooShik.saveDropPath
import com.upar24.chattingtrading.util.KangDooShik.savePartyPath
import com.upar24.chattingtrading.util.KangDooShik.saveTodayPath
import com.upar24.chattingtrading.util.KangDooShik.saveTradingPath
import com.upar24.chattingtrading.util.KangDooShik.saveWallPath
import com.upar24.chattingtrading.util.KangDooShik.toggleCheckPath
import com.upar24.chattingtrading.util.KangDooShik.toggleDropPath
import com.upar24.chattingtrading.util.KangDooShik.toggleNopePath
import com.upar24.chattingtrading.util.KangDooShik.updateUserPath
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CTFApi {

    @POST(registerPath)
    suspend fun register(
        @Body registerRequest: AccountRequest
    ): Response<SimpleResponse>

    @POST(loginPath)
    suspend fun login(
        @Body loginRequest: AccountRequest
    ):Response<SimpleResponse>

    @POST(getUserPath)
    suspend fun getUser(
        @Body oneRequest: OneRequest
    ):Response<User>

    @POST(updateUserPath)
    suspend fun updateProfile(
        @Body updateUserReq: UpdateUserRequest
    ):Response<SimpleResponse>

    @POST(saveWallPath)
    suspend fun saveWall(
        @Body wall: Wall
    ):Response<SimpleResponse>

    @POST(getWallPath)
    suspend fun getWall(
        @Body getRequest : OneRequest
    ):Response<List<Wall>>

    @POST(deleteWallPath)
    suspend fun deleteWall(
        @Body wall:Wall
    ):Response<SimpleResponse>

    @POST(saveChatPath)
    suspend fun saveChat(
        @Body chat: Chat
    ):Response<SimpleResponse>

    @GET(getChatPath)
    suspend fun getChat():Response<List<Chat>>

    @POST(saveTradingPath)
    suspend fun saveTrading(
        @Body trading: Trading
    ):Response<SimpleResponse>

    @POST(deleteTradingPath)
    suspend fun deleteTrading(
        @Body trading:Trading
    ):Response<SimpleResponse>

    @GET(getAllTradingPath)
    suspend fun getAllTrading():Response<List<Trading>>

    @POST(getAllUserTradingPath)
    suspend fun getAllUserTrading(
        @Body username:OneRequest
    ):Response<List<Trading>>

    @POST(getTradingPath)
    suspend fun getTrading(
        @Body trading: Trading
    ):Response<Trading>

    @POST(getBuyingSearchPath)
    suspend fun getBuyingSearch(
        @Body query:OneRequest
    ):Response<List<Trading>>

    @POST(getSellingSearchPath)
    suspend fun getSellingSearch(
        @Body query:OneRequest
    ):Response<List<Trading>>

    @POST(getTitleSearchPath)
    suspend fun getTitleSearch(
        @Body query:OneRequest
    ):Response<List<Trading>>

    @POST(getDescriptionSearchPath)
    suspend fun getDescriptionSearch(
        @Body query:OneRequest
    ):Response<List<Trading>>

    @POST(getPartyPath)
    suspend fun getPartyList(
        @Body query: OneRequest
    ):Response<List<Party>>

    @GET(saveDropPath)
    suspend fun getDrop():Response<List<Dropped>>

    @GET(saveTodayPath)
    suspend fun getToday():Response<Today>

    @POST(toggleCheckPath)
    suspend fun toggleCheck(
        @Body party: Party
    ):Response<ResponseBody>

    @POST(toggleDropPath)
    suspend fun toggleDrop(
        @Body party: Party
    ):Response<ResponseBody>

    @POST(toggleNopePath)
    suspend fun toggleNope(
        @Body party: Party
    ):Response<ResponseBody>

    @POST(getListUserPath)
    suspend fun getListUser(
        @Body listUsername: ListStringRequest
    ):Response<List<User>>

    @POST(getListUserClubPath)
    suspend fun ListUserClub(
        @Body clubName:OneRequest
    ):Response<List<User>>

    @POST(getListUserIgnPath)
    suspend fun ListUserIgn(
        @Body ignName:OneRequest
    ):Response<List<User>>


}