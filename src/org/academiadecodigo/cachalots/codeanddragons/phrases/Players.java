package org.academiadecodigo.cachalots.codeanddragons.phrases;

public enum Players {

        FireMagePath("Fire mage"),
        CowardNinjaPath("Tank Warrior"),
        TankWarriorPath("Coward Ninja");

        private final String text;

        Players(final String text) {
                this.text = text;
        }

        @Override
        public String toString() {
                return text;
        }
}

