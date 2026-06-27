# Common-libra
Shared utility library used across team projects

## 🛠️ Requirements
<li>Java 17</li>
<li>Maven 3.9.10</li>

## 🚀 Module
A Java tools class for file, encryption , bean share , cache service , captcha authorize , as well as providing the following modules:

| Module        | Description                                      |
|---------------|--------------------------------------------------|
| common-all    | included all modules                             |
| common-util   | tools file in java that have re-build with exception |
| common-cache  | provided service logic with technologies , such as: `Redis` |
| common-capcha | this tool for system security to avoid from bot  |

## 📦 Dependency

```
    <dependency>
        <groupId>xyz.hldev.libra-common</groupId>
        <artifactId>common-all</artifactId>
        <version>1.0.0</version>
    </dependency>
```
After inject the dependency so let run :
`mvn clean package`

<b>Please make sure have `settings.xml` in `~/.m2` in your maven path. if it's not so please copy from directory setting and pastes in `~/.m2`</b>
<p style="color: red"><i>This package also use library from CN.HUTOOL</i></p>