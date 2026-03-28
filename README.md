🐾 Kef-La-Hayot: Professional E2E Automation & QA Strategy
🌟 Executive Summary
This project is a comprehensive automation and manual testing suite for the "Kef-La-Hayot" e-commerce platform. It demonstrates a full QA lifecycle—from strategic planning (STP) to automated execution and executive reporting (STR).

The highlight of this project is the discovery of 13 significant bugs, including a critical legal compliance blocker.

📊 Project Insights & Presentation
[!IMPORTANT]
> **[📊 Click here to view the Interactive Project Presentation (STR)](https://docs.google.com/presentation/d/e/2PACX-1vTOF0UBZ5-NZYzlSUIyLPEaatsvW49CcG2ed1wF7Y3-O2SgaMuk_LUQ-zeYnDGO3-jr_kpn8P363piL/pub?start=true&loop=false&delayms=10000&slide=id.p)**

> **[📊 Click here to view the Interactive Project Video Demo (STR)](https://www.canva.com/design/DAHDwmFgX7s/S8T6Vkwk4g0_rniwiU45IQ/watch?utm_content=DAHDwmFgX7s&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=hb7d1ac700b)**

Includes full bug analysis, risk assessment, and the final GO/NO-GO decision.

🚀 Key Features & Architecture
Hybrid Framework: Built with Selenium WebDriver and TestNG for robust E2E testing.

Page Object Model (POM): Ensures high maintainability and clean code separation.

Advanced Evidence Capturing: Integrated CDP (Chrome DevTools Protocol) to capture full-page screenshots of layout failures.

Detailed Reporting: Allure Reports with step-by-step logging and dynamic attachments.

🛠️ Tech Stack
Category	Tool
Language	Java 17+
Automation	Selenium WebDriver
Testing Framework	TestNG
Reporting	Allure Framework
Build Tool	Maven


🐞 Top Critical Findings
Automation discovered 13 functional and UI/UX defects. Here are the top 3:

ID	    Title	                        Severity	    Impact
Bug-06	T&C Acceptance Bypass	        🛑 Blocker	    Legal & Compliance Risk
Bug-07	Duplicate Phone Registration	🔴 Critical	    Data Integrity Issue
Bug-12	Content Rendering Failure	    🟠 Major	    UX Friction / Empty States


[!TIP]
Each bug in the report includes a highlighted screenshot (using custom HighlightUtils) to point directly to the failure.

🎞️ Visual Evidence
Allure Reporting Dashboard
A high-level view of test execution and severity distribution.

Automation in Action
Watch the Selenium suite performing cross-page validations.

🔧 Getting Started
Clone & Navigate:


git clone https://github.com/ItzhakLevy1/kef-la-hayot-automation.git
cd kef-la-hayot-automation
Run Tests:


mvn clean test
Generate Report:


allure serve target/allure-results


👤 Author
Itzhak Levy

Full Stack Developer & QA Automation Engineer

https://www.linkedin.com/in/itzhak-levy-66bb671bb/ | https://itzhaklevy1.github.io/Portfolio-2026/