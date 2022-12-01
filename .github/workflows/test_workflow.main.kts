#!/usr/bin/env kotlin

@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.32.0")

import it.krzeminski.githubactions.actions.actions.CheckoutV3
import it.krzeminski.githubactions.domain.RunnerType.UbuntuLatest
import it.krzeminski.githubactions.domain.triggers.Push
import it.krzeminski.githubactions.dsl.workflow
import it.krzeminski.githubactions.yaml.toYaml

val workflow = workflow(
    name = "Test workflow",
    on = listOf(Push()),
    sourceFile = __FILE__.toPath(),
) {
    __FILE__
    job(id = "test_job", runsOn = UbuntuLatest) {
        uses(name = "Check out", action = CheckoutV3())
        run(name = "test", command = "./gradlew test")
    }
}

println(workflow.toYaml())