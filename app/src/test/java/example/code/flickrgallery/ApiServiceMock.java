package example.code.flickrgallery;

import android.support.design.widget.AppBarLayout;

import example.code.flickrgallery.gallery.GalleryPresenter;
import example.code.flickrgallery.network.ApiService;
import example.code.flickrgallery.network.model.JsonFlickrFeed;
import retrofit2.Call;
import retrofit2.mock.BehaviorDelegate;


public class ApiServiceMock implements ApiService{

private GalleryPresenter galleryPresenter;
private final AppBarLayout.BehaviorDelegate <ApiService> delegate;




    @Override
    public Call<JsonFlickrFeed> getFeed() {
        return null;
    }
}
