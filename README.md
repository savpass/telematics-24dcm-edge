# telematics-24dcm-edge

ProjectName Java CI Pipeline
1. Introduction
This document outlines a CI pipeline using GitHub and GitHub Actions, designed to streamline the development, testing, and deployment processes for the ProjectName Java software.

2. Branching Strategy
dev
Purpose: This branch contains the latest development code. All new features and bug fixes are developed in separate branches created from this one.
Protection: Only allow merges via pull requests (PRs) that have passed the dev CI flow.
staging
Purpose: This branch is for code that has passed functional and performance testing. It is ready for integration testing and final evaluation.
Protection: Only allow merges from the dev branch via PRs that have passed the staging CI flow.
main
Purpose: This branch contains production-ready code. Merges into this branch are from the staging branch after integration testing and team cross-checking.
Protection: Only allow merges from the staging branch via PRs that have passed manual cross-checks and final evaluations.
3. Folder Structure
src: Source code for the Java application.
docs: Project documentation and use case specifications.
test: Files for software evaluation.
unit-test: Unit testing files.
functional-test: Functional evaluation environment and test cases.
4. New Development Workflow
1. Checkout a New Branch from dev
Ensure your local repository is up-to-date with the latest changes from the remote dev repository:
bash
Copy code
git checkout dev
git pull origin dev
Create a new branch for your feature or bug fix. Choose a branch name that is easily understood and reflects the changes being made:
bash
Copy code
git checkout -b feat-branch
2. Develop New Features or Fix Bugs
Implement necessary code changes following coding standards for Java (e.g., Google Java Style Guide).
3. Create or Update Unit Tests
Write new unit tests or update existing ones to cover your changes. Ensure your tests are comprehensive and follow the testing guidelines (e.g., JUnit). Always run the unit tests locally before committing your changes.
4. Commit and Push Changes
Stage your changes:
bash
Copy code
git add .
Commit your changes with a descriptive message:
bash
Copy code
git commit -m "Feature or bug fix description"
Push your branch to the remote repository:
bash
Copy code
git push origin feat-branch
5. Create a Pull Request to dev
Go to the GitHub repository and navigate to the "Pull Requests" tab. Click "New pull request." Select your branch as the source and dev as the target. Add a descriptive title and a detailed description of your changes. Submit the pull request.
5. CI Flows
1. New Development to dev
Trigger: After a pull request to dev.

Steps:

Linting: Correct syntax errors, apply formatting, and ensure coding standards (e.g., Checkstyle).
Unit Test: Run unit tests to validate the expected behavior of isolated code (e.g., JUnit).
Coverage Test: Verify the effectiveness of unit tests and identify uncovered code (e.g., JaCoCo).
Team cross-check: After automated steps, the pull request is manually reviewed by the team for specification coverage and non-automated code checks. Once all steps are successful, changes can be merged into the dev branch.

2. dev to staging
Trigger: After a pull request to staging.

Steps:

Build Evaluation Environment: Compile and package the Java application into a deployable artifact (e.g., Maven or Gradle).
Functional Test: Perform functional tests to ensure the application meets the required specifications.
Performance Test: Run performance tests to monitor resource utilization and ensure the application meets performance criteria (e.g., JMeter).
Merge: Once all steps are successful, changes are merged into the staging branch.

3. staging to main
Trigger: After a pull request to main.

Steps:

System Integration Test: Deploy the application to a staging environment for end-to-end testing.
User Acceptance Test (UAT): Conduct UAT with stakeholders to validate the application against business requirements.
TMC Review: Before production deployment, the software must be reviewed and approved by the Technical Management Committee (TMC).

4. Production Deployment
After all previous steps are successfully performed, the software can be prepared for production deployment.
