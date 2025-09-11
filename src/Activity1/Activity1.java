package src.Activity1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Activity1 {
    public static void main(String[] args) {
    List<Errors> errorsList = Arrays.asList(
            new Errors("2025-08-01T03:00:00", "Connection timeout", Priority.MEDIUM),
            new Errors("2025-10-01T12:00:00", "Low Battery", Priority.LOW)
    );

    User user = new  User(
            "Cristian Galeano",
            "cgaleano@jala.university",
            1,
            "192.168.1.14",
            "CGaleano",
            "Ubuntu LTS",
            "2025-07-30T02:00:00",
            "2025-10-01T15:00:00",
            errorsList
    );

    try {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(user);
        Files.write(Paths.get("user.json"), jsonString.getBytes());

        System.out.println("user JSON already serialized and saved into user.json");
        System.out.println(jsonString);

         String jsonFromFile = new String(Files.readAllBytes(Paths.get("user.json")));

         User deserializedUser = gson.fromJson(jsonFromFile, User.class);

        System.out.println("Deserialized user JSON - Name: " + deserializedUser.getName());


    }catch (IOException e){
        System.out.println("Error to process JSON: " + e.getMessage());
        e.printStackTrace();
    }

    try {
        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller  marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try (FileWriter fw = new FileWriter("user.xml")){
            marshaller.marshal(user, fw);
        }

        System.out.println("\nXML serialized and saved in user.xml");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        try (FileReader fr = new FileReader("user.xml")) {
            User deserializedUser = (User) unmarshaller.unmarshal(fr);
            System.out.println("Deserialized user XML - Name: " + deserializedUser.getName());
            System.out.println("Deserialized user XML - Errors: " + deserializedUser.getErrors().get(1).getPriority());
        }
    }catch (JAXBException | IOException e){
        System.out.println("Error to process XML: " + e.getMessage());
        e.printStackTrace();
    }



    }
}
