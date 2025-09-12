package src.Activity2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Activity2 {
    public static void main(String[] args) {
        Student student = new Student(
                "Cristian",
                "Galeano",
                "A",
                1,
                21,
                new Address("Colombia", "Cundinamarca", "Funza", "Cll 18", "#15-25"),
                "3204067486"
        );

        /*
        * Serialized - MessagePack - JSON - XML
        */
        try {
            ObjectMapper mapper = new ObjectMapper( new MessagePackFactory());
            byte[] msgpack = mapper.writeValueAsBytes(student);
            Files.write(Paths.get("student.msgpack"), msgpack);
            System.out.println("MessagePack " + msgpack.length + " bytes (student.msgpack)" );
        }catch (IOException e){
            System.out.println("Error to serialize MessagePack: " + e.getMessage());
        }

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(student);
            Files.write(Paths.get("student.json"), json.getBytes(StandardCharsets.UTF_8));
            System.out.println("JSON " + json.getBytes(StandardCharsets.UTF_8).length + " bytes (student.json)" );
        }catch (IOException e){
            System.out.println("Error to serialize JSON: " + e.getMessage());
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            marshaller.marshal(student, sw);
            String xml = sw.toString();
            Files.write(Paths.get("student.xml"), xml.getBytes(StandardCharsets.UTF_8));
            System.out.println("XML " + xml.getBytes(StandardCharsets.UTF_8).length + " bytes (student.xml)" );
        }catch (JAXBException | IOException e){
            System.out.println("Error to serialize XML: " + e.getMessage());
        }

        /*
         * Deserialized - MessagePack
         */

        try {
            ObjectMapper mapper = new ObjectMapper( new MessagePackFactory());
            byte[] msgpack = Files.readAllBytes(Paths.get("student.msgpack"));
            Student deserializedStudent = mapper.readValue(msgpack, Student.class);
            System.out.println("Deserialized student " + deserializedStudent.getName() + " - Grade: " + deserializedStudent.getGrade());
        }catch (IOException e){
            System.out.println("Error to deserialized MessagePack: " + e.getMessage());
        }

        /*
        * MD5 - MessagePack - JSON - XML
         */

        try {
            byte[] msgpack = Files.readAllBytes(Paths.get("student.msgpack"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5hash = md5.digest(msgpack);
            String md5HashString = HexFormat.of().formatHex(md5hash);
            System.out.println("MD5 - MessagePack: " + md5HashString);
        }catch (IOException | NoSuchAlgorithmException e){
            System.out.println("Error to calculate MD5 MessagePack: " + e.getMessage());
        }

        try {
            byte[] jsonBytes = Files. readAllBytes(Paths.get("student.json"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5hash = md5.digest(jsonBytes);
            String md5HashString = HexFormat.of().formatHex(md5hash);
            System.out.println("MD5 - JSON: " + md5HashString);
        }catch (IOException | NoSuchAlgorithmException e){
            System.out.println("Error to calculate MD5 JSON: " + e.getMessage());
        }

        try {
            byte[] xmlBytes = Files.readAllBytes(Paths.get("student.xml"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5hash = md5.digest(xmlBytes);
            String md5HashString = HexFormat.of().formatHex(md5hash);
            System.out.println("MD5 - XML: " + md5HashString);
        }catch (IOException | NoSuchAlgorithmException e){
            System.out.println("Error to calculate MD5 XML: " + e.getMessage());
        }

        try {
            System.out.println("\nSize (bytes):");
            System.out.println("student.msgpack: " + Files.size(Paths.get("student.msgpack")));
            System.out.println("student.json: " + Files.size(Paths.get("student.json")));
            System.out.println("student.xml: " + Files.size(Paths.get("student.xml")));
        }catch (IOException e){
            System.out.println("Error to calculate sizes: " + e.getMessage());
        }


    }
}
