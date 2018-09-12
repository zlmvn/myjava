package cn.javass.xgen.genconf;

import cn.javass.xgen.genconf.vo.GenConfModel;
import cn.javass.xgen.genconf.vo.GenTypeModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;

import java.util.Map;

/**
 * Created by flyap on 2018/7/17.
 */
public class GenCnfEbo implements GenConfEbi{


    @Override
    public GenConfModel getGenConf() {
        return null;
    }

    @Override
    public Map<String, ModuleConfModel> getMapModuleConf() {
        return null;
    }

    @Override
    public GenTypeModel getThemeGenType(ModuleConfModel moduleConf, String needGenTypeId) {
        return null;
    }

    @Override
    public String getThemeGenOutTypeClass(ModuleConfModel moduleConf, String genOutTypeId) {
        return null;
    }
}
