/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package jdk.tools.jlink.internal;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import jdk.tools.jlink.internal.plugins.PluginsResourceBundle;
import jdk.tools.jlink.plugins.ImageBuilder;

/**
 *
 */
public class DefaultImageBuilderProvider {

    public static final String COPY_FILES = "copy-files";
    public static final String GEN_BOM = "genbom";
    public static final String JIMAGE_NAME_PROPERTY = "jimage.name";
    public static final String NAME = "jlink-default-image-builder";

    private static final Map<String, String> OPTIONS = new HashMap<>();

    static {
        OPTIONS.put(COPY_FILES, PluginsResourceBundle.getOption(NAME, COPY_FILES));
        OPTIONS.put(GEN_BOM, PluginsResourceBundle.getOption(NAME, GEN_BOM));
    }
    public ImageBuilder newBuilder(Properties properties,
            Path imageOutDir,
            Map<String, Path> mods) throws IOException {
        return new DefaultImageBuilder(properties, imageOutDir, mods);
    }

    public static Map<String, String> getOptions() {
        return OPTIONS;
    }

    public static boolean hasArgument(String option) {
        return option.equals(COPY_FILES);
    }

}
