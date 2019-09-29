package models;

import models.AnimalOwner;

public interface Sellable {
    boolean sellTo(AnimalOwner owner);
    int getPrice();
}
