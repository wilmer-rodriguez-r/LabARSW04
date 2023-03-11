package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubFilter implements Filter {

    @Override
    public Blueprint filter(Blueprint bp) {
        List<Point> points = bp.getPoints();
        List<Point> filterPoints = new ArrayList<>();
        if(points.size() == 0) {
            return null;
        }
        for(int i = 0; i < points.size(); i++) {
            if(i%2 != 1) {
                filterPoints.add(points.get(i));
            }
        }
        Point[] filterPointsAux = new Point[filterPoints.size()];
        filterPointsAux = filterPoints.toArray(filterPointsAux);
        return new Blueprint(bp.getAuthor(), bp.getName(), filterPointsAux);
    }
}
