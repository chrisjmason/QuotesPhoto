package data

/**
 * Created by cmason on 08/02/2018.
 */
import io.reactivex.Single
import retrofit2.http.GET

interface PhotoService
{
    @GET("photos")
    fun getPhoto(): Single<List<PhotoModel>>
}