package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;

public interface Filter {
    public Blueprint filter(Blueprint bp);
}
