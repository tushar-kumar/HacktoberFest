#include<stdio.h>
#include<stdlib.h>
struct Node{
    int data;
    struct Node *next,*prev;
}*head=NULL;
void takeInput(){
    struct Node *tail=NULL;
    int class=1;
    while(class!=0){
        struct Node *Newnode=malloc(sizeof(struct Node));
        int num;
        printf("Enter the element  ");
        scanf("%d",&num);
        Newnode->data=num;
        Newnode->prev=NULL;
        Newnode->next=NULL;
        if(head==NULL)
        head=tail=Newnode;
        else{
            tail->next=Newnode;
            Newnode->prev=tail;
            tail=Newnode;
        }
        printf("if you want to stop list press 0 otherwise press any other number\n");
        scanf("%d",&class);
    }
}
void displayNum(struct Node *p){
    while(p!=NULL){
        printf("%d ",p->data);
        p=p->next;
    }
}

void insertAB(struct Node *p,int x){
struct Node* newNode=malloc(sizeof(struct Node));
newNode->prev=NULL;
newNode->data=x;
newNode->next=p;
p->prev=newNode;
head=newNode;
}
void insertAE(struct Node *p,int x){
    struct Node *q=p;
    struct Node* newNode=malloc(sizeof(struct Node));
    newNode->next=NULL;
    newNode->data=x;
    while(q->next!=NULL)
    q=q->next;
    q->next=newNode;
    newNode->prev=q;
    
}
void insertAP(struct Node *p,int x,int pos){
struct Node *q;
struct Node *newNode=malloc(sizeof(struct Node));
    newNode->data=x;
    int i=0;
    while(i<pos-1){
    q=p;
    p=p->next;
    i++;
    }
    p->prev=newNode;
    newNode->prev=q;
    newNode->next=p;
    q->next=newNode;
}
void deleteBeg(struct Node *p){
    struct Node *temp=head;
    head=head->next;
    free(temp);
}
void deleteEnd(struct Node *p){
    struct Node *q=p;
    while(q->next->next!=NULL){
    q=q->next;}
free(q->next);
q->next=NULL;    
}
void deleteAny(struct Node *p,int pos){
    struct Node *temp=head;
    struct Node *temp2;
    int i=1;
    while(i<pos-1) temp=temp->next;
    temp2=temp->next;
    temp->next=temp2->next;
    temp2->next->prev=temp->next;
    free(temp2);

}
int main(){
    takeInput();
    displayNum(head);
    printf("\n");
    int pos,x,y;
    printf("\nEnter the position where you want to insert\n");
    scanf("%d",&pos);
    printf("enter the input to insert\n");
    scanf("%d",&x);
    // insertAB(head,x);
    // displayNum(head);
    //scanf("%d",&y);
    //insertAE(head,y);
    //displayNum(head);
    // deleteBeg(head);
    // displayNum(head);
    // printf("\n");
    // deleteEnd(head);
    // displayNum(head);
    // printf("\n");
    //  int z;
    //  printf("Deletion any point\n");
    //  scanf("%d",&z);
    //  deleteAny(head,z);
    insertAP(head,x,pos);
    displayNum(head);
return 0;
}