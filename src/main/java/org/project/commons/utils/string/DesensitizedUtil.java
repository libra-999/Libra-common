package org.project.commons.utils.string;

public class DesensitizedUtil
{

    public static String password(String password)
    {
        if (StringUtils.isBlank(password))
        {
            return StringUtils.EMPTY;
        }
        return StringUtils.repeat('*', password.length());
    }
}
