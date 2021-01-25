import businesslayer.BusinessLayer;
import businesslayer.Child;
import businesslayer.Parent;
import filehandler.DataLayerApi;
import filehandler.HashMapHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestBusinessLayer {
/*
    @Test
    public void when_asked_to_display_children_call_datalayer_get_list_of_IStorageObjects() throws IOException {
        BusinessLayer businessLayer = new BusinessLayer();
        HashMapHandler hashMapHandler = new HashMapHandler();
        System.out.println(businessLayer.displayChildren());
        Assertions.assertEquals(businessLayer.displayChildren(), hashMapHandler.getKeySetFromhashMap(DataLayerApi.CHILD));
    }

    @Test
    public void when_asked_to_save_child_send_to_file_handler_fetch_child() throws IOException {
        BusinessLayer businessLayer = new BusinessLayer();
        Parent[] parents = new Parent[2];
        Child child = new Child("Martin", "Peterson", "bar", 2015, parents);
        businessLayer.saveIStorageObject(child);
        Child child2 = (Child) businessLayer.fetchIStorageObject("Martin", DataLayerApi.CHILD);
        Assertions.assertEquals(child.getName(), child2.getName());
    }*/
}
