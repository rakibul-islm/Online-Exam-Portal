import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCandidateComponent } from './pages/admin/add-candidate/add-candidate.component';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';
import { AddExamQuestionComponent } from './pages/admin/add-exam-question/add-exam-question.component';
import { AddExamComponent } from './pages/admin/add-exam/add-exam.component';
import { AddQuestionComponent } from './pages/admin/add-question/add-question.component';
import { AddQuizComponent } from './pages/admin/add-quiz/add-quiz.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { ResultComponent } from './pages/admin/result/result.component';
import { UpdateCandidateComponent } from './pages/admin/update-candidate/update-candidate.component';
import { UpdateExamComponent } from './pages/admin/update-exam/update-exam.component';
import { UpdateQuizComponent } from './pages/admin/update-quiz/update-quiz.component';
import { ViewCandidateComponent } from './pages/admin/view-candidate/view-candidate.component';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { ViewExamQuestionsComponent } from './pages/admin/view-exam-questions/view-exam-questions.component';
import { ViewExamsComponent } from './pages/admin/view-exams/view-exams.component';
import { ViewQuizQuestionsComponent } from './pages/admin/view-quiz-questions/view-quiz-questions.component';
import { ViewQuizzesComponent } from './pages/admin/view-quizzes/view-quizzes.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { CandidateDashboardComponent } from './pages/canidate/candidate-dashboard/candidate-dashboard.component';
import { ExamInstructionsComponent } from './pages/canidate/exam-instructions/exam-instructions.component';
import { ExamStartComponent } from './pages/canidate/exam-start/exam-start.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { InstructionsComponent } from './pages/user/instructions/instructions.component';
import { LoadQuizComponent } from './pages/user/load-quiz/load-quiz.component';
import { StartComponent } from './pages/user/start/start.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { AdminGuard } from './services/admin.guard';
import { CandidateGuard } from './services/candidate.guard';
import { NormalGuard } from './services/normal.guard';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'signup', component: SignupComponent
  },
  {
    path: 'login', component: LoginComponent
  },


  {
    path: 'admin', component: DashboardComponent, canActivate: [AdminGuard],
    children: [
      {
        path: '', component: WelcomeComponent,
      },
      {
        path: 'profile', component: ProfileComponent,
      },
      {
        path: 'categories', component: ViewCategoriesComponent,
      },
      {
        path: 'add-category', component: AddCategoryComponent,
      },
      {
        path: 'quizzes', component: ViewQuizzesComponent,
      },
      {
        path: 'add-quiz', component: AddQuizComponent,
      },
      {
        path: 'quiz/:qid', component: UpdateQuizComponent,
      },
      {
        path: 'view-questions/:qid/:title', component: ViewQuizQuestionsComponent,
      },
      {
        path: 'add-question/:qid/:title', component: AddQuestionComponent,
      },
      


      {
        path: 'exams', component: ViewExamsComponent,
      },
      {
        path: 'add-exam', component: AddExamComponent,
      },
      {
        path: 'exam/:exId', component: UpdateExamComponent,
      },
      {
        path: 'exam-questions/:exId/:title', component: ViewExamQuestionsComponent,
      },
      {
        path: 'add-exam-question/:qid/:title', component: AddExamQuestionComponent,
      },
      {
        path: 'add-candidate/:exId', component: AddCandidateComponent,
      },
      {
        path: 'view-candidate/:exId', component: ViewCandidateComponent,
      },
      {
        path: 'update-candidate/:username/:exId', component: UpdateCandidateComponent,
      },
      {
        path: 'results/:exId', component: ResultComponent,
      },
    ]
  },


  {
    path: 'user', component: UserDashboardComponent, canActivate: [NormalGuard],
    children: [
      {
        path: ':catId', component: LoadQuizComponent,
      },
      {
        path: 'instructions/:qid', component: InstructionsComponent,
      },
    ],
  },


  {
    path: 'candidate', component: CandidateDashboardComponent, canActivate: [CandidateGuard],
  },

  {
    path: 'instructions/:title/:exId', component: ExamInstructionsComponent, canActivate: [CandidateGuard],
  }, 

  {
    path: 'exam-start/:username/:exId', component: ExamStartComponent, canActivate: [CandidateGuard],
  },

  {
    path: 'start/:qid', component: StartComponent, canActivate: [NormalGuard],
  },


];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
