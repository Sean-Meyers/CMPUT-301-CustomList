import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.*;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    private CustomList mockCityList() {
        CustomList cityList = new CustomList(null, new ArrayList<City>());
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void testHasCity() {
        CustomList cityList = mockCityList();

        City city = new City("hello", "world");
        assertFalse(cityList.hasCity(city));
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    public void testDelete() {
        CustomList cityList = mockCityList();
        City city = new City("ipsum", "lorem");
        //assertThrows(IllegalArgumentException.class, () -> {
        //    cityList.delete(city);
        //});
        cityList.add(city);
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }
}
