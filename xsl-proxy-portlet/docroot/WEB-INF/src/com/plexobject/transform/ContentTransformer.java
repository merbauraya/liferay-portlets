package com.plexobject.transform;

import java.util.Map;

public interface ContentTransformer {
    /**
     * This method transforms given contents
     * 
     * @param contents
     *            - input contents
     * @param properties
     *            - input/output properties for transformation
     * @return transformed contents
     * @throws TransformationException
     *             - when error occurs while transforming content.
     */
    public String transform(String contents, Map<String, String> properties)
            throws TransformationException;
}
