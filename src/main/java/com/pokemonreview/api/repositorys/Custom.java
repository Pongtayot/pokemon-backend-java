package com.pokemonreview.api.repositorys;

import com.pokemonreview.api.models.Pokemon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class Custom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pokemon> findByCriteria(String name) {
        // ระมัดระวัง SQL injection โดยการ escape ค่า
        String sanitizedName = sanitizeInput(name);

        // สร้างคำสั่ง SQL โดยตรง
        String sqlQuery = "SELECT COUNT(*) FROM t_actor WHERE column = '" + sanitizedName + "'";

        // สร้าง Query และ execute
        Query query = entityManager.createNativeQuery(sqlQuery, Pokemon.class);
        return query.getResultList();
    }

    private String sanitizeInput(String input) {
        // นำค่า input มา escape หรือทำความสะอาดตามที่เหมาะสม
        // ตัวอย่าง: ในกรณีนี้อาจใช้ EntityManager หรือ Query.setParameter ในกรณีที่ไม่เหมาะ
        // หรือใช้วิธี escape อื่น ๆ ที่เหมาะสมตามสถานการณ์
        return input;
    }

}