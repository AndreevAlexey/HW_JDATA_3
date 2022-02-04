package hw_jdata_3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomersRepository {
    private static final String PRODS_QUERY = "select_prods_by_name.sql";
    private String prodsQuery;

    public String getProdsQuery() {
        if(prodsQuery == null || prodsQuery.isEmpty()) prodsQuery = read(PRODS_QUERY);
        return prodsQuery;
    }

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<String> getProductName(String name) {
        return namedParameterJdbcTemplate.queryForList(getProdsQuery(), Collections.singletonMap("name", name), String.class);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
