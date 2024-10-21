/*
Builder Pattern
Intent: Used to construct complex objects step by step.

Real-Life Example: Building a house, step by step (foundations, walls, roof).
 */

package kkm.designpatterns.creational.builder;

class House {
    private String foundation;
    private String walls;
    private String roof;

    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.walls = builder.walls;
        this.roof = builder.roof;
    }

    static class HouseBuilder {
        private String foundation;
        private String walls;
        private String roof;

        public HouseBuilder buildFoundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public HouseBuilder buildWalls(String walls) {
            this.walls = walls;
            return this;
        }

        public HouseBuilder buildRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    @Override
    public String toString() {
        return "House with foundation: " + foundation + ", walls: " + walls + ", and roof: " + roof;
    }
}

public class Example {
    public static void main(String[] args) {
        House house = new House.HouseBuilder()
                .buildFoundation("Concrete")
                .buildWalls("Brick")
                .buildRoof("Shingles")
                .build();
        System.out.println(house);
        // House with foundation: Concrete, walls: Brick, and roof: Shingles
    }
}

