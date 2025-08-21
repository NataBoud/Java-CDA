package com.example.demo_session_rest.service;


import com.example.demo_session_rest.model.Cat;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CatService {

    private HttpSession session;
    private int cpt = 1;

    public CatService(HttpSession session) {
        this.session = session;
    }

    public void addCat(Cat cat) {
        Map<Integer, Cat> map = (Map<Integer, Cat>) session.getAttribute("catMap");
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(cpt++, cat);
        session.setAttribute("catMap", map);
    }

    public Map<Integer, Cat> getCatMap() {
        return (Map<Integer, Cat>) session.getAttribute("catMap");
    }


}
