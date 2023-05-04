/*
 * Copyright 2023 Udo Cirkel (www.udocirkel.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.archplan.ddd.lang.pattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an annotated package represents a "Bounded Context" as defined
 * by Domain-Driven Design (Eric Evans, 2003)
 * <p>
 * A Bounded Context is an abstraction for modeling a part of a domain (aka
 * subdomain) with its own ubiquitous language, closely related concepts and
 * rules. The purpose of a Bounded Context is to define a boundary for a domain
 * model and its related domain concepts. It is useful for reducing complexity,
 * avoiding domain overlap and helping domain experts and developers to focus on
 * a specific area of the domain. Modeling Bounded Contexts allows domains to be
 * broken down into smaller, more manageable parts that are easier to reason
 * about, maintain, and evolve over time independently.
 * <p>
 * <b>Characteristics</b>
 * <p>
 * Ubiquitous language - A Bounded Context has its own ubiquitous language that
 * is used by business owners, domain experts and developers to communicate
 * concepts within the according part of the domain. Each term has a specific
 * meaning within a Bounded Context. When the same term is used in different
 * Bounded Contexts, then it typically has different meanings.
 * <p>
 * Boundary - A Bounded Context has a clearly defined boundary that separates it
 * from other Bounded Contexts. The boundary defines which concepts reside
 * within the Bounded Context and which do not.
 * <p>
 * Domain model - A Bounded Context has its own domain model that is tailored to
 * the specific needs of that context. The domain model within a Bounded Context
 * may be different from the domain model used in other contexts.
 * <p>
 * Relationships - A Bounded Context may have relationships with other Bounded
 * Contexts. These relationships may include sharing data or collaborating on
 * business processes. The relationships between Bounded Contexts should be
 * clearly defined and mapped to ensure that they are consistent and
 * well-defined.
 * <p>
 * Consistency - The domain model within a Bounded Context should be internally
 * consistent, with a clear understanding of the business rules and constraints
 * that apply within that context.
 * <p>
 * Ownership - According to the ubiquitous language the ownership of a Bounded
 * Context is owned by exactly one team. A team may also be responsible for
 * multiple Bounded Contexts. A Bounded Context is never owned by more than one
 * team, because this would lead to the loss of clarity about the meaning of
 * terms in the ubiquitous language.
 * <p>
 * <b>Modeling hints</b>
 * <p>
 * Bounded Contexts are useful to create a clear and well-defined boundary
 * around a specific subdomain or business capability, with a shared language
 * and consistent set of rules and concepts. The following criteria may guide
 * with modeling.
 * <p>
 * Business capabilities - A Bounded Context should align with a specific
 * business capability or subdomain of the (overall) domain. The boundary should
 * be defined based on the business capabilities that are being served by the
 * context.
 * <p>
 * Ubiquitous language - A Bounded Context should have a well-defined, shared
 * language that is specific to that context. The language should be used
 * consistently by everyone involved in the context, including business owners,
 * domain experts and developers. A term or concept might mean one thing in one
 * context and something different in another context.
 * <p>
 * Team structure - A Bounded Context should be aligned with the way that teams
 * are organized and communicate with each other. It should take into account
 * the team structure and communication patterns within the organization.
 * <p>
 * Consistency - A Bounded Context should be internally consistent and coherent.
 * The concepts and rules within the context should make sense and be logical in
 * relation to each other.
 * <p>
 * Technology - A Bounded Context may also define a technical boundary, if there
 * are technical requirements that must be considered.
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DddPattern("Bounded Context")
public @interface DddBoundedContext {

    /**
     * Unique identifier of the Bounded Context
     * 
     * @return an identifier or an empty string
     */
    String id() default "";

    /**
     * Name of the Bounded Context as defined in the domain model and equally in the
     * ubiquitous language
     * <p>
     * {@link #value()} is an alias for this attribute.
     * 
     * @return a name or an empty string
     */
    String name() default "";

    /**
     * Alias for the {@link #name()} attribute
     * <p>
     * Allows a more concise declaration of annotations such as
     * {@code @DddBoundedContext("A meaningful name")} instead of
     * {@code @DddBoundedContext(name="A meaningful name")}. Only one of these
     * attributes may be specified.
     * 
     * @return a name or an empty string
     */
    String value() default "";

    /**
     * Concise description of the Bounded Context
     * 
     * @return a description or an empty string
     */
    String description() default "";

    /**
     * Additional information that is related to the Bounded Context
     * <p>
     * The provided information is specified in key-value form, where keys may occur
     * multiple times
     *
     * @return an array with attribute elements or an empty array
     */
    Attribute[] attributes() default {};

}