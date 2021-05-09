package com.lmb.hello.factory;


import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 工厂模式
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws InvalidRuleConfigException {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}

class InvalidRuleConfigException extends Exception {
    InvalidRuleConfigException(String errMsg){
        super(errMsg);
    }
}

class RuleConfig {

}

class RuleConfigParserFactory {

    private static final Map<String,IRuleConfigParser> cacheParsers = Maps.newHashMap();

    /**
     * 初始化工厂
     *
     */
    static {
        cacheParsers.put("json",new JsonRuleConfigParser());
        cacheParsers.put("xml",new XmlRuleConfigParser());
        cacheParsers.put("yaml",new YamlRuleConfigParser());
        cacheParsers.put("properties",new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser getParser(String configFormat){
        if(configFormat ==null || configFormat.isEmpty()){
            throw new IllegalArgumentException();
        }
        IRuleConfigParser iRuleConfigParser = cacheParsers.get(configFormat);
        return iRuleConfigParser;
    }

    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}

interface IRuleConfigParser {
    RuleConfig parse(String configText);

}

class JsonRuleConfigParser implements IRuleConfigParser {

    @Override
    public RuleConfig parse(String configText) {
        return null;
    }
}

class XmlRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return null;
    }
}

class YamlRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return null;
    }
}

class PropertiesRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return null;
    }
}