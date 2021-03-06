package com.autentia.concesionario.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.concesionario.dao.mappers.CarMapper;
import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.CarService;

@Service("carService")
public class CarServiceImpl implements CarService {

    private static final Logger LOG = LoggerFactory.getLogger(CarService.class);

    private final CarMapper carMapper;

    @Autowired
    public CarServiceImpl(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    @Override
    public void insert(Car car) {
        LOG.info("Guardando coche en base de datos: {}", car.toString());
        carMapper.insert(car);
    }

    @Override
    public Car get(int id) {
        LOG.info("Cargando coche con Id: {}", id);
        return carMapper.get(id);
    }

    @Override
    public List<Car> getAll() {
        LOG.info("Cargando lista de coches");
        return carMapper.getAll();
    }

}
