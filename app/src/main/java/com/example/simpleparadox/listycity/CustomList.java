package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;
    }

    /**
     * Get the size of the list
     * @return
     */
    public int getCount() {
        return cities.size();
    }

    /**
     * Add a city object to the list
     * @param city
     */
    public void addCity(City city) {
        cities.add(city);
        return;
    }

    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Remove the City from the list if it exists.
     *
     * @param city
     *      The city to remove.
     *
     * @throws IllegalArgumentException
     *      If the city is not in the list.
     */
    public void delete(City city) {
        if (!hasCity(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Count the number of cities in the list.
     *
     * @return
     *      The number of cities in the list.
     */
    public int countCities() {
        return cities.size();
    }
}
