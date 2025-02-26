package com.dev.ldt.NewSpring.KienTrucSpring.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class checkDataBase {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        public String checkConnection() {
            try {
                // Truy vấn kiểm tra tên cơ sở dữ liệu
                String databaseName = jdbcTemplate.queryForObject("SELECT DATABASE()", String.class);
                return "Kết nối thành công! Cơ sở dữ liệu hiện tại: " + databaseName;
            } catch (Exception e) {
                return "Kết nối thất bại! Lỗi: " + e.getMessage();
            }
        }
    }

