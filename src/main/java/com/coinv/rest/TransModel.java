package com.coinv.rest;

import com.coinv.model.JSONModelFormat3;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * Created by lv-wei on 2018-03-27.
 */
@RestController
public class TransModel {

    @RequestMapping("/tm")
    public JSONModelFormat3 JSONModelFormat3(@RequestParam String xyz) {

        System.out.println("Who call me? xyz:" + xyz);

        JSONModelFormat3 retVal = new JSONModelFormat3();

        // TODO
        // For test
        String fileName = "c:\\projects\\angular\\three-partice2\\src\\assets\\scene\\square.json";
        String json = "";
        try {
            json = FileUtils.readFileToString(
                    new File(fileName),
                    "GBK"
            );

            ObjectMapper om = new ObjectMapper();
            retVal = om.readValue(json, JSONModelFormat3.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retVal;
    }
}
