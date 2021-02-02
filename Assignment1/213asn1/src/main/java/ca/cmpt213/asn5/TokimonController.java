package ca.cmpt213.asn5;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class TokimonController {

    List<Tokimon> allTokimons = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {
        allTokimons.clear();
        Resource resource = new ClassPathResource("data/tokimon.json");
        JsonObject jobj = new JsonParser().parse(new InputStreamReader(resource.getInputStream())).getAsJsonObject();
        JsonArray jArr = jobj.getAsJsonArray("tokimons");
        for (int i=0;i<jArr.size();i++) {
            JsonObject jtokimon = jArr.get(i).getAsJsonObject();
            Tokimon tokimon = new Tokimon();
            tokimon.setId(jtokimon.get("id").getAsString());
            tokimon.setName(jtokimon.get("name").getAsString());
            tokimon.setWeight(jtokimon.get("weight").getAsInt());
            tokimon.setHeight(jtokimon.get("height").getAsInt());
            tokimon.setFly(jtokimon.get("fly").getAsInt());
            tokimon.setFire(jtokimon.get("fire").getAsInt());
            tokimon.setWater(jtokimon.get("water").getAsInt());
            tokimon.setElectric(jtokimon.get("electric").getAsInt());
            tokimon.setFreeze(jtokimon.get("freeze").getAsInt());
            tokimon.setStrength(jtokimon.get("strength").getAsInt());
            tokimon.setColor(jtokimon.get("color").getAsString());

            allTokimons.add(tokimon);
        }

    }


    @GetMapping(value = "/api/tokimon/all")
    public List<Tokimon> getAllTokimon() throws IOException {
        init();
        return allTokimons;
    }

    @GetMapping(value = "/api/tokimon/{id}")
    public Tokimon getTokimonById(@PathVariable String id, HttpServletResponse response) throws IOException {
        init();
        for (Tokimon tokimon: allTokimons) {
            if(Objects.equals(tokimon.getId(), id)){
                return tokimon;
            }
        }
        response.setStatus(404);
        return null;
    }

    @PostMapping(value = "/api/tokimon/add")
    public Tokimon addTokimon(@RequestBody Tokimon tokimon, HttpServletResponse response) throws IOException {
        Tokimon t = getTokimonById(tokimon.getId(), response);
        if(t==null) {
            Resource resource = new ClassPathResource("data/tokimon.json");
            JsonObject jobj = new JsonParser().parse(new InputStreamReader(resource.getInputStream())).getAsJsonObject();
            JsonArray jArr = jobj.getAsJsonArray("tokimons");
            JsonObject jtokimon = new JsonObject();
            jtokimon.addProperty("id", tokimon.getId());
            jtokimon.addProperty("name", tokimon.getName());
            jtokimon.addProperty("weight", tokimon.getWeight());
            jtokimon.addProperty("height", tokimon.getHeight());
            jtokimon.addProperty("fly", tokimon.getFly());
            jtokimon.addProperty("fire", tokimon.getFire());
            jtokimon.addProperty("water", tokimon.getWater());
            jtokimon.addProperty("electric", tokimon.getFly());
            jtokimon.addProperty("freeze", tokimon.getFreeze());
            jtokimon.addProperty("strength", tokimon.getStrength());
            jtokimon.addProperty("color", tokimon.getColor());
            jArr.add(jtokimon);
            BufferedWriter bw= new BufferedWriter(new FileWriter(resource.getFile()));
            bw.write(jobj.toString());
            bw.flush();
            bw.close();

            response.setStatus(201);
            return tokimon;
        }
        return null;
    }

    @RequestMapping(value = "/api/tokimon/{id}", method = RequestMethod.DELETE)
    public void delTokimon(@PathVariable String id, HttpServletResponse response) throws IOException {
        Resource resource = new ClassPathResource("data/tokimon.json");
        JsonObject jobj = new JsonParser().parse(new InputStreamReader(resource.getInputStream())).getAsJsonObject();
        JsonArray jlist = jobj.getAsJsonArray("tokimons");
        boolean temp = false;
        for (int i=0;i<jlist.size();i++) {
            JsonObject jtokimon = jlist.get(i).getAsJsonObject();
            String jid = jtokimon.get("id").getAsString();
            if(Objects.equals(jid, id)) {
                jlist.remove(i);
                temp = true;
                break;
            }
        }

        BufferedWriter bw= new BufferedWriter(new FileWriter(resource.getFile()));
        bw.write(jobj.toString());
        bw.flush();
        bw.close();
        if(temp)
            response.setStatus(200);
        else
            response.setStatus(404);
    }

}
