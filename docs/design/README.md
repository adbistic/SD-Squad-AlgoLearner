# AlgoLearn: Design

We designed every screen of AlgoLearn in **Figma** before writing any code, and connected them into a clickable prototype.

- **Figma file:** [AlgoLearn in Figma](https://www.figma.com/design/iZJJfAQTRYyBPHsRrOvDmR/AlgoLearn)
- **Clickable prototype:** [Open the prototype](https://www.figma.com/proto/iZJJfAQTRYyBPHsRrOvDmR/AlgoLearn?node-id=9-2&starting-point-node-id=9%3A2) (starts on the Home screen)

## Design system

A dark theme with **bordeaux** as the main colour, the **Inter** font, and one colour per level, so students always know where they are. The Figma file stores these as colour variables, text styles and components, and every screen uses them.

| Colour | Hex | Used for |
|---|---|---|
| Bordeaux | `#C23A62` | Main buttons, progress, highlights |
| Background | `#120E10` | Page background |
| Card | `#1D1719` | Cards and the top bar |
| Easy | `#4CC38A` | Easy level, correct answers |
| Intermediate | `#E3A63F` | Intermediate level |
| Hard | `#A08CF0` | Hard level |
| Wrong | `#F0646C` | Wrong answers |

**Text styles:** 9 styles, from Title (Inter Extra Bold 34) to Code (JetBrains Mono 13).

**Components:** Button (primary, secondary, disabled, with hover states), Badge (6 colours) and Answer option (default, selected, correct, wrong).

![Colours and typography](design-system/foundations.png)

| Buttons | Badges | Answer options |
|---|---|---|
| ![Button](design-system/button.png) | ![Badge](design-system/badge.png) | ![Answer option](design-system/answer-option.png) |

## User flow

Home → Level → Lesson → Quiz → Quiz feedback → Results. Passing a quiz with 60% or more unlocks the next level; "Watch it run" on a lesson opens the visualizer.

## Screens

### Home

![Home](screens/01-home.png)

### Easy level

![Easy level](screens/02-easy-level.png)

| Linear Search | Bubble Sort | Selection Sort |
|---|---|---|
| ![Linear Search](screens/03-easy-linear-search.png) | ![Bubble Sort](screens/04-easy-bubble-sort.png) | ![Selection Sort](screens/05-easy-selection-sort.png) |

| Quiz | Quiz feedback | Results |
|---|---|---|
| ![Easy quiz](screens/06-easy-quiz.png) | ![Easy quiz feedback](screens/07-easy-quiz-feedback.png) | ![Easy results](screens/08-easy-results.png) |

### Visualizer

![Visualizer](screens/09-visualizer.png)

### Intermediate level

![Intermediate level](screens/10-intermediate-level.png)

| Binary Search | Insertion Sort | Merge Sort |
|---|---|---|
| ![Binary Search](screens/11-intermediate-binary-search.png) | ![Insertion Sort](screens/12-intermediate-insertion-sort.png) | ![Merge Sort](screens/13-intermediate-merge-sort.png) |

| Quiz | Quiz feedback | Results |
|---|---|---|
| ![Intermediate quiz](screens/14-intermediate-quiz.png) | ![Intermediate quiz feedback](screens/15-intermediate-quiz-feedback.png) | ![Intermediate results](screens/16-intermediate-results.png) |

The Hard level uses the same screens with its purple colour.
