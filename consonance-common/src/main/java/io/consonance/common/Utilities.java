/*
 *     Consonance - workflow software for multiple clouds
 *     Copyright (C) 2016 OICR
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package io.consonance.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;

import java.io.File;

/**
 * @author dyuen
 */
public class Utilities {

    public static HierarchicalINIConfiguration getYouxiaConfig() {
        File configFile = new File(System.getProperty("user.home"), ".consonance/config");
        return Utilities.parseConfig(configFile.getAbsolutePath());
    }

    public static HierarchicalINIConfiguration parseConfig(String path) {
        try {
            return new HierarchicalINIConfiguration(path);
        } catch (ConfigurationException ex) {
            throw new RuntimeException("Could not read ~/.consonance/config");
        }
    }
}
