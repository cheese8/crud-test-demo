package com.github.cheese8.dbunit;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleXmlDataSetLoader extends AbstractDataSetLoader {

    @Override
    protected IDataSet createDataSet(Resource resource) throws Exception {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        try (InputStream inputStream = resource.getInputStream()) {
            return newReplacementDataSet(builder.build(inputStream));
        }
    }

    private ReplacementDataSet newReplacementDataSet(FlatXmlDataSet dataSet) {
        ReplacementDataSet replacementDataSet = new ReplacementDataSet(dataSet);
        replacementDataSet.addReplacementObject("[null]", null);
        replacementDataSet.addReplacementObject("[NULL]", null);
        replacementDataSet.addReplacementObject("[NOW]", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm.00").format(LocalDateTime.now()));
        return replacementDataSet;
    }
}