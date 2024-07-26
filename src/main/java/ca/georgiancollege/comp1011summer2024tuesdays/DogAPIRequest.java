package ca.georgiancollege.comp1011summer2024tuesdays;

import com.google.gson.Gson;

public class DogAPIRequest extends APIUtility{

    StringBuilder json = new StringBuilder();
    private Gson gson = new Gson();

    public Dog getData(String url){
        json.setLength(0);
        json.append(sendRequest(url));

        Dog dog = gson.fromJson(json.toString(), Dog.class);

        return dog;
    }
    public DogByBreed getDogByBreed(){
        String url = "https://dog.ceo/api/breed/hound/images";

        json.setLength(0);
        json.append(sendRequest(url));

        return gson.fromJson(json.toString(), DogByBreed.class);
    }
    public DogListAllBreeds getAllDogBreeds(){

        String url = "https://dog.ceo/api/breeds/list/all";

        json.setLength(0);
        json.append(sendRequest(url));

        return gson.fromJson(json.toString(), DogListAllBreeds.class);

    }
}
