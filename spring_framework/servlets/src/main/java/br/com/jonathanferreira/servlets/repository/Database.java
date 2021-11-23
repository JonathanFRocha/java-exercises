package br.com.jonathanferreira.servlets.repository;

import br.com.jonathanferreira.servlets.entities.Company;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static List<Company> companyList = new ArrayList<>();

    static {
        Company company1 = new Company();
        company1.setName("test1");
        Company company2 = new Company();
        company2.setName("test2");
        companyList.add(company2);
        companyList.add(company1);
    }

    public void save(Company company) {
        companyList.add(company);
    }

    public List<Company> getCompanyList() {
        return Database.companyList;
    }
}
