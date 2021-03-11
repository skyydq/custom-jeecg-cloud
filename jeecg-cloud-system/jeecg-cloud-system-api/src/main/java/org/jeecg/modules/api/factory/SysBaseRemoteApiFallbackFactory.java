package org.jeecg.modules.api.factory;

import feign.hystrix.FallbackFactory;
import org.jeecg.modules.api.SysBaseRemoteApi;
import org.jeecg.modules.api.fallback.SysBaseRemoteApiFallback;
import org.springframework.stereotype.Component;

/**
 * @author taoyan
 * @date 2020/05/22
 */
@Component
public class SysBaseRemoteApiFallbackFactory implements FallbackFactory<SysBaseRemoteApi> {

    @Override
    public SysBaseRemoteApi create(Throwable throwable) {
        SysBaseRemoteApiFallback fallback = new SysBaseRemoteApiFallback();
        fallback.setCause(throwable);
        return fallback;
    }

}
