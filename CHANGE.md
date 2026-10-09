<h1>🚀Changelog</h1>

# 1.1.0(2026-06-27)

### Refactor structure
* 【all, capcha, util , cache】
  * Renamed several files for better consistence
  * Refactored the capcha implementation to reduce duplicate logic from `hutool-all`
* 【*.md】 Added license attribution for  cn.hutool
### Add LINE_CAPTCHA
* 【 capcha】       
  * Added a simplified LineCaptcha implementation to make captcha integration easier and reduce the amount of setup code required. 
* 【 util】  
  * Added captcha utility methods for image rendering based on the generated captcha code.
  * Added color and RGB utility functions.
  * Added `SHA-256` encryption utilities for secure hashing
]()

# 1.0.1(2026-06-23)

### Modify DNS
* 【all, capcha, util , cache】 modified artifact from hldev.xyz.libra-common -> xyz.hldev.libra-common
* 【*.md】 display the introduction to developer if they want to build mvn central

# 1.0.0(2026-06-23)

### init
* 【all 】 init all modules and client can current module by calling `Common` class
* 【capcha 】 still working
* 【util 】 init
* 【cache 】 just build some methods that most common in used
