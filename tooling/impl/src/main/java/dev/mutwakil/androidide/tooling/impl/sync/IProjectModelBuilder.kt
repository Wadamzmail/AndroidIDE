package dev.mutwakil.androidide.tooling.impl.sync

import dev.mutwakil.androidide.project.GradleModels

/**
 * A [model builder][IModelBuilder] used specifically building project models.
 *
 * @author Akash Yadav
 */
interface IProjectModelBuilder<P> : IModelBuilder<P, GradleModels.GradleProject>