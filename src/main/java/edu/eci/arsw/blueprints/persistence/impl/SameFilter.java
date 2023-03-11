package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public class SameFilter implements Filter {

    @Override
    public Blueprint filter(Blueprint bp) {
        List<Point> points = bp.getPoints();
        List<Point> filterPoints = new ArrayList<>();
        if(points.size() == 0) {
            return null;
        }
        filterPoints.add(points.get(0));
        for(int i = 1; i < points.size(); i++) {
            if(points.get(i).getX() != points.get(i - 1).getX() || points.get(i).getY() != points.get(i - 1).getY()) {
                filterPoints.add(points.get(i));
            }
        }
        Point[] filterPointsAux = new Point[filterPoints.size()];
        filterPointsAux = filterPoints.toArray(filterPointsAux);
        return new Blueprint(bp.getAuthor(), bp.getName(), filterPointsAux);
    }

}
