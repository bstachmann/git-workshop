# Continuous Integration with GitLab

# Agenda

## Block1 Basics of CI/CD

 * CI
   * Git-Flow
   * Merge Hell
 * Workflow: Developing together on the master

 * CI/CD

## Block2 Using GitLab for CI/CD

## Block3 Building Workflows for CI/CD

# Material

I demonstrate with some examples how CI/CD can be implemented with GitLab. I report on CI/CD solutions I know from practice. Then we discuss strategies on how this can be implemented at Rohde and Schwarz. In the practical part, the examples are adapted and extended.

## Why?
 * Matze's 70 steps to 1

 * Cycle Times -- Dave Farley
   * Flow:
     - Fewer interruptions for developers
     - No Q/A bottleneck
   * Faster feedback, experiments
 * Smaller
   * Easier conflicts (horror of Release)
   * Faster troubleshooting
 * Code Quality/One Version

## What?

 * CI
    * Master
    * Build system
    * Build Pipeline
    * Reviews Quality Curve

Lead time, deployment frequency, mean time to restore (MTTR), and change fail percentage.

 * CD
    * Deployment
    * Monitoring
 * Artifact repository
   * Or Docker image registry
 * GitLab Runner
 * GitLab Job + yml
 * Feature Toggling

## How?

 * Trunk-based Development
   - Worst way to use branches
   - ZeroMQ way
 * When to merge
 * Auto DevOps
 * Tests Unit/Module/Integration tests
   - Speed/Parallelization
 * Dependencies/Modularization

## Where to next?

 * Release documentation
 * Infrastructure as Code
 * Kubernetes
 * Monorepo
