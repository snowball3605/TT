/*
 * JDA-Commands allows you to easily create commands in JDA.
 * Copyright (C) 2020 Dreta https://dretacbe.github.io
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.dretacbe.jdacommands.arguments.types;

import io.github.dretacbe.jdacommands.arguments.ArgumentParseException;

/**
 * Represents a double argument.
 */
public class DoubleArgument implements ArgumentType<Double> {
    private double max = Double.MAX_VALUE;
    private double min = Double.MIN_VALUE;

    public DoubleArgument() {
    }

    public DoubleArgument(double max) {
        this.max = max;
    }

    public DoubleArgument(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Double parse(String[] args, String name, int start) throws ArgumentParseException {
        try {
            double d = Double.parseDouble(args[start]);
            if (d > max || d < min) {
                throw new ArgumentParseException("Argument " + name + " must be between " + min + " and " + max + ", however it is " + d + ".");
            }
            return d;
        } catch (NumberFormatException e) {
            throw new ArgumentParseException("Argument " + name + " must be a valid number!");
        }
    }
}
