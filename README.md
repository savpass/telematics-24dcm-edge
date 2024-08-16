# **ProjectName Java CI Pipeline**

## 1. Introduction
This document outlines a CI pipeline using GitHub and GitHub Actions, designed to streamline the development, testing, and deployment processes for the **ProjectName** Java software.

## 2. Branching Strategy

### **dev**
- **Purpose**: This branch contains the latest development code. All new features and bug fixes are developed in separate branches created from this one.
- **Protection**: Only allow merges via pull requests (PRs) that have passed the `dev` CI flow.

### **staging**
- **Purpose**: This branch is for code that has passed functional and performance testing. It is ready for integration testing and final evaluation.
- **Protection**: Only allow merges from the `dev` branch via PRs that have passed the `staging` CI flow.

### **main**
- **Purpose**: This branch contains production-ready code. Merges into this branch are from the `staging` branch after integration testing and team cross-checking.
- **Protection**: Only allow merges from the `staging` branch via PRs that have passed manual cross-checks and final evaluations.

## 3. Folder Structure

- **src**: Source code for the Java application.
- **docs**: Project documentation and use case specifications.
- **test**: Files for software evaluation.
- **unit-test**: Unit testing files.
- **functional-test**: Functional evaluation environment and test cases.

## 4. New Development Workflow

### **1. Checkout a New Branch from `dev`**
- Ensure your local repository is up-to-date with the latest changes from the remote `dev` repository:
  ```bash
  git checkout dev
  git pull origin dev
