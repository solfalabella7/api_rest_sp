package utn.api_rest_sp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import utn.api_rest_sp.entities.Base;

import java.io.Serializable;

public interface BaseController <E extends Base, ID extends Serializable> {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete(@PathVariable ID id);
}