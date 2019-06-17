package example.code.flickrgallery;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import example.code.flickrgallery.gallery.GalleryContract;
import example.code.flickrgallery.gallery.GalleryPresenter;
import example.code.flickrgallery.network.ApiService;
import example.code.flickrgallery.network.model.Item;
import example.code.flickrgallery.network.model.Media;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GalleryPresenterTest {
    private GalleryPresenter galleryPresenter;
    private List<Item> itemList;


    @Mock
    private GalleryContract.View galleryContractView;

    @Spy
    private ApiService apiServiceSpy;

    @Mock
    private ApiService apiService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks( this );
        Item item = new Item();
        Media media=new Media();
        media.setM( "https://uk.images.search.yahoo.com/yhs/search;_ylt=AwrIRlAkX21btW4A3E53Bwx.;_ylu=X3oDMTByZmVxM3N0BGNvbG8DaXIyBHBvcwMxBHZ0aWQDBHNlYwNzYw--?p=images&fr=yhs-Lkry-SF01&hspart=Lkry&hsimp=yhs-SF01#id=107&iurl=https%3A%2F%2Fc.pxhere.com%2Fphotos%2F01%2F70%2Fpudong_shanghai_china_bund_skyscraper_tower_sun_sunset-1028002.jpg!d&action=click");
        item.setMedia( media );
        item.setTitle( "Title" );
        item.setAuthor( "Author" );
        item.setDateTaken( "10/8/10" );

        Item item2 = new Item();
        Media media2=new Media();
        media.setM( "https://uk.images.search.yahoo.com/yhs/search;_ylt=AwrIRlAkX21btW4A3E53Bwx.;_ylu=X3oDMTByZmVxM3N0BGNvbG8DaXIyBHBvcwMxBHZ0aWQDBHNlYwNzYw--?p=images&fr=yhs-Lkry-SF01&hspart=Lkry&hsimp=yhs-SF01#id=107&iurl=https%3A%2F%2Fc.pxhere.com%2Fphotos%2F01%2F70%2Fpudong_shanghai_china_bund_skyscraper_tower_sun_sunset-1028002.jpg!d&action=click");
        item.setMedia( media );
        item.setTitle( "Title" );
        item.setAuthor( "Author" );
        item.setDateTaken( "10/8/10" );

        Item item3 = new Item();
        Media media3=new Media();
        media.setM( "https://uk.images.search.yahoo.com/yhs/search;_ylt=AwrIRlAkX21btW4A3E53Bwx.;_ylu=X3oDMTByZmVxM3N0BGNvbG8DaXIyBHBvcwMxBHZ0aWQDBHNlYwNzYw--?p=images&fr=yhs-Lkry-SF01&hspart=Lkry&hsimp=yhs-SF01#id=107&iurl=https%3A%2F%2Fc.pxhere.com%2Fphotos%2F01%2F70%2Fpudong_shanghai_china_bund_skyscraper_tower_sun_sunset-1028002.jpg!d&action=click");
        item.setMedia( media );
        item.setTitle( "Title" );
        item.setAuthor( "Author" );
        item.setDateTaken( "10/8/10" );

        itemList = new ArrayList<>(  );
        itemList.add( item );
        itemList.add( item2 );
        itemList.add( item3 );

        return delegate.returningResponse(itemList).getFeed();

        galleryPresenter = new GalleryPresenter( galleryContractView, apiService  );

    }

    @Test
    public void galleryPresenter_whenLoadingImages_ApiGetFeedIsCalled() {
        verify( galleryContractView ).setPresenter( galleryPresenter );
    }

    @Test
    public void galleryPresenter_whenSettingTheView_ViewIsSet() {

        galleryPresenter = new GalleryPresenter( galleryContractView, apiServiceSpy  );
        galleryPresenter.loadGallery( false );
       verify(apiServiceSpy).getFeed();


    }
    @Test
    public void setGalleryPresenter_whenGalleryViewIsActive_returnTrue(){
        when(galleryContractView.isActive()).thenReturn(true);

        assertTrue (galleryContractView.isActive());
    }

}

