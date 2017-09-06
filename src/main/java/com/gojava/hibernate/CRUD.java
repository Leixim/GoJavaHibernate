package com.gojava.hibernate;

import java.util.List;

public interface CRUD {

    public Object getByID();

    public List getAll();

    public void create();

    public void deleteByID();

    public void deleteAll();

    public void updateByID();

}
